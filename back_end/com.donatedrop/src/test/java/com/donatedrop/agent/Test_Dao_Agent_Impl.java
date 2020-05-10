package com.donatedrop.agent;

import com.donatedrop.agent.models.AgentRequest;
import com.donatedrop.agent.models.RequestGetAgentRequestsReview;
import com.donatedrop.other.DumpDao;
import com.donatedrop.other.TestUtil;
import com.donatedrop.util.DateUtil;
import com.donatedrop.util.StringUtil;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class Test_Dao_Agent_Impl {

    @Autowired
    Dao_Agent_I dao_agent_i;

    @Autowired
    DumpDao dumpDao;

    @Test
    @Order(1)
    public void testObject() {
        System.out.println("\nM2\n");
        System.out.println("\ndao_agent_i : " + dao_agent_i.toString() + "\n");
    }

    @Test
    @Order(2)
    public void testSaveRequest() {
        AgentRequest agentRequest = new AgentRequest();
        agentRequest.setUserID(TestUtil.userID + 3);
        agentRequest.setRequestDate(DateUtil.getDate().toString());
        agentRequest.setStatus("0");
        Map<String, String> result = dao_agent_i.saveRequest(agentRequest);
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    @Order(3)
    public void testReviewRequest() {
//        String id = dumpDao.getUsers(0, 10).get(0).getId().toString();
        Map<String, String> result = dao_agent_i.reviewRequest("22904", "-1");
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    public void testDeleteRequest() {
        Map<String, String> result = dao_agent_i.deleteRequest("16" + 1);
        System.out.println("\nResult : \n" + result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    public void testGetAllRequestAgent() {
        dao_agent_i.getAgentRequests(0, 10).forEach(ar -> {
            System.out.println(ar.toString());
        });
    }

    @Test
    public void testGetAgentRequestsToReview() {
        RequestGetAgentRequestsReview agentRequestsReview = new RequestGetAgentRequestsReview(0, 30, "username", "%1%");
        dao_agent_i.getAgentRequestsToReview(agentRequestsReview).forEach(agentRequestReview -> {
            String addr = agentRequestReview.getPermanentStreet()
                    + " " + agentRequestReview.getPermanentUnion()
                    + ", " + agentRequestReview.getPermanentUpz()
                    + ", " + agentRequestReview.getPermanentDist()
                    + ", " + agentRequestReview.getPermanentDiv();
            System.out.println(addr);
            System.out.println(agentRequestReview.getPhone_number());
            System.out.println(agentRequestReview.getUsername());
            System.out.println("-------------------------------");
        });
    }

    @Test
    public void testGetAgentRequestsReviewCount() {
        Map<String, String> result = dao_agent_i.getAgentRequestsToReviewCount("username", "%1%");
        System.out.println(result);
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));
    }

    @Test
    public void testGetAgentRequestsReviewPhoneNumber() {
        RequestGetAgentRequestsReview agentRequestsReview = new RequestGetAgentRequestsReview(0, 30, "username", "%15%");
        dao_agent_i.getAgentRequestsToReview(agentRequestsReview).forEach(agentRequestReview -> {
            System.out.println(agentRequestReview.toString());
        });
    }

    @Test
    public void testUpdateAdminNote() {
        String requestID = dao_agent_i.getAgentRequests(0, 10).get(0).getId().toString();
        System.out.println(requestID);
    }

    //    not part dao layer
    @Test
    public void testInsertAgent() {
        dumpDao.getUsers(0, 20).forEach(user -> {
            AgentRequest agentRequest = new AgentRequest();
            agentRequest.setUserID(user.getId().toString());
            agentRequest.setRequestDate(DateUtil.getDate().toString());
            agentRequest.setStatus("0");
            Map<String, String> result = dao_agent_i.saveRequest(agentRequest);
            System.out.println("\nResult : \n" + result);
        });
    }


}
