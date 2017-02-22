package service;

import dao.PostingDao;
import java.util.List;
import model.Posting;
import model.User;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class WebLogService {

    @Inject
    private PostingDao postingDao;

    public WebLogService() {        
    }

    /**
     *
     * @param posting
     * @param user
     * @return false if user is not allowed to post if user is allowed to post
     * true if posting is created, the nrPost of user is increased false if
     * posting is not created
     *
     * a user is not allowed to post if status = 0 and nrPost >= 5
     */
    public boolean addPosting(Posting posting, User user) {
        if (user.getStatus() == 0 && user.getNrPosts() >= 5) {
            return false;
        } else {
            boolean result = postingDao.create(posting);
            if (result) user.increaseNrPosts();
            return result;
        }
    }

    public List<Posting> getPostings() {
        return postingDao.findAll();
    }

    void setPostingDao(PostingDao postingDao) {
        this.postingDao = postingDao;
    }
    
    

}
