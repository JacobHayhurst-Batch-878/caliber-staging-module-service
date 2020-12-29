package com.revature.backend.testing.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.backend.model.Associate;
import com.revature.backend.model.Batch;
import com.revature.backend.util.BatchWriter;
import com.revature.backend.util.BatchWriterImpl;

@SpringBootTest(classes={BatchWriter.class, BatchWriterImpl.class})
@RunWith(SpringRunner.class)
public class BatchWriterTesting {
    @Autowired
	BatchWriterImpl batchWriter;
	
	@Test
	void testWriteNewlyStagingAssociates() {
        //set up the mock list
        List<Associate> aList = new ArrayList<Associate>();

        //add some dummy entities (use Mockito here)
        Associate associateA = mock(Associate.class);
        Associate associateB = mock(Associate.class);
        Associate associateC = mock(Associate.class);
        aList.add(associateA);
        aList.add(associateB);
        aList.add(associateC);

        //run the test method
        batchWriter.writeNewlyStagingAssociates(aList);
        //verify that the save occured at least once
        verify(batchWriter, times(1)).writeNewlyStagingAssociates(aList);
    }
    
    @Test
	void testWriteNewlyStagingBatches() {
        
        //add some dummy entities (use Mockito here)
        
        //verify that the save occured at least once
        //set up the mock list
        List<Batch> bList = new ArrayList<Batch>();
        
        //add some dummy entities (use Mockito here)
        Batch batchA = mock(Batch.class);
        Batch batchB = mock(Batch.class);
        Batch batchC = mock(Batch.class);
        bList.add(batchA);
        bList.add(batchB);
        bList.add(batchC);

        //run the test method
        batchWriter.writeNewlyStagingBatches(bList);
        //verify that the save occured at least once
        verify(batchWriter, times(1)).writeNewlyStagingBatches(bList);
	}

}
