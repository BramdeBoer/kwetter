/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.annotation.PostConstruct;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup
public class StartUp {
    
    private long execID;
    private JobOperator jobOperator;
    private static final long serialVersionUID = 3712686178567411830L;

      
    public StartUp() {
    }
     
    @PostConstruct
    private void intData(){
        System.out.println("START IMPORT");
        jobOperator = BatchRuntime.getJobOperator();
        execID = jobOperator.start("tweetimport", null);
    }
    
}
