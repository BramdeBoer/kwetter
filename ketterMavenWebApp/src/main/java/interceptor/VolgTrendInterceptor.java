package interceptor;

import model.Tweet;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Created by bramd on 22-3-2017.
 */
@Interceptor
@VolgTrend
public class VolgTrendInterceptor {

    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic) throws Exception {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        Object[] params = ic.getParameters();
        params[0] = ((String)params[0]).replace("vet", "dik").replace("cool", "hard");
        ic.setParameters(params);
        return ic.proceed();
    }

}
