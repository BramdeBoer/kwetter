import { TwitterAppPage } from './app.po';

describe('twitter-app App', function() {
  let page: TwitterAppPage;

  beforeEach(() => {
    page = new TwitterAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
