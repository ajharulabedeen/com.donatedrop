package com.donatedrop.agent.doner;

import com.donatedrop.agent.donner.Dao_AgentDonner_I;
import com.donatedrop.agent.donner.Dao_DonnerAssign_I;
import com.donatedrop.agent.donner.models.DonnerAssingment;
import com.donatedrop.agent.donner.models.DonnerRequestToAgent;
import com.donatedrop.other.DumpDao;
import com.donatedrop.other.DumpData;
import com.donatedrop.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import java.util.Map;

@SpringBootTest
public class Test_Dao_DonnerAssign_Impl {

    @Autowired
    DumpDao dumpDao;

    @Autowired
    Dao_DonnerAssign_I dao_donnerAssign_i;

    @Test
    public void testSaveDonnerAssingment() {
        String agentUserID = dumpDao.getAgentRequest(0, 100, StringUtil.ACCEPT)
                .get(0).getUserID();
        String donnerUserID = dumpDao.getDonnerOfAAgent(0, 100, agentUserID).get(0).getUserIdDonner();

        DonnerAssingment donnerAssingment = new DonnerAssingment();
        donnerAssingment.setAgentId(agentUserID);
        donnerAssingment.setDonnerId(donnerUserID);
        donnerAssingment.setNeedDate(DumpData.getDate());
        Map<String, String> result = dao_donnerAssign_i.save(donnerAssingment);
//        Map<String, String> result = null;
        System.out.println("\n" + result + "\n");
        assertEquals(StringUtil.OK, result.get(StringUtil.STATUS));

    }


}