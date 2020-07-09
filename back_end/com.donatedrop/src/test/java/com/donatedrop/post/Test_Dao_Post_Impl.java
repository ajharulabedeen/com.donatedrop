package com.donatedrop.post;

import com.donatedrop.other.DumpDao;
import com.donatedrop.other.DumpData;
import com.donatedrop.security.models.User;
import com.donatedrop.util.StringUtil;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class Test_Dao_Post_Impl {
    @Autowired
    DumpDao dumpDao;

    @Autowired
    Dao_Post_I dao_post_i;

    @Test
    @Order(1)
    public void test_savePost() {
        Map<String, String> status = null;
        List<User> userList = dumpDao.getUsers(0, 10);
        Random random = new Random();
        List<PostComment> comments = new ArrayList<>();
        String useID = userList.get(random.nextInt(userList.size() - 1)).getId().toString();
        for (int y = 0; y <= random.nextInt(5); y++) {
            PostComment postComment = new PostComment(DumpData.getDate(), DumpData.getNote(), useID);
            comments.add(postComment);
        }

        Post post = new Post(
                userList.get(random.nextInt(userList.size() - 1)).getId().toString(),
                DumpData.getBloodGroup(),
                dumpDao.getAddressString("PRESENT"),
                DumpData.getHospitalName(),
                DumpData.getHospitalAddress(),
                DumpData.getGender(),
                DumpData.getPatientDescription(),
                "20-10-10",
                DumpData.getDate(),
                DumpData.getQuantity(),
                DumpData.getPhoneNumber(),
                "0",
                DumpData.getNote(),
                "NO",
                "SON",
                DumpData.getNote(),
                "NA",
                DumpData.getNote(),
                comments);

        status = dao_post_i.savePost(post);
        storeID(status.get(StringUtil.ID));
        storeUserID(useID);
        Assert.assertEquals(StringUtil.OK, status.get(StringUtil.STATUS));
    }

    @Test
    public void test_findPostByUserIDNoComment() {
//        `post_id`=20618 `post_user_id`=12417
        Post p = dao_post_i.findPostByUserIDNoComment("12417", "20619");
//        System.out.println(p.getHospitalAddress());
//        Assert.assertNotEquals(p, null);
//        Assert.assertNotNull(p);
        Assert.assertNull(p);
    }

    @Test
    public void testFindOneByID() {
//        `post_id`=20618;
        Post p = dao_post_i.findOnePostByID(getID());
//        System.out.println(p.getPostID());
        Assert.assertNull(p);
    }

    @Test
    public void testUpdatePost() {
        String userID = getUserID();
        String postID = getID();
        Map<String, String> status = null;
        Post p = dao_post_i.findOnePostByID(postID);
        System.out.println("\n>>>" + p.getNotes() + "\n");
//        String updateNote = "NotaUpdated! No Blood Need!";
        String updateNote = "Stupid People, haveing money by no means.";
        p.setNotes(updateNote);
        status = dao_post_i.updatePost(p);
        Post updatedP = dao_post_i.findOnePostByID(postID);
        Assert.assertEquals(StringUtil.OK, status.get(StringUtil.STATUS));
        Assert.assertEquals(updateNote, updatedP.getNotes());
        System.out.println("\n>>>" + updatedP.getNotes() + "\n");
    }


    @Test
    public void testDeletePost() {
        String userID = getUserID();
        String postID = getID();
        Map<String, String> status = null;
        Post p = dao_post_i.findOnePostByID(postID);
//        System.out.println("\n>>>" + p.getNotes() + "\n");
        status = dao_post_i.deletePost(postID);
        Post updatedP = dao_post_i.findOnePostByID(postID);
        Assert.assertEquals(StringUtil.OK, status.get(StringUtil.STATUS));
        Assert.assertNull(updatedP);
    }

    @Test
    public void testGetPostWithComments() {
        Post p = dao_post_i.findPostWithComments(getID());
        if (p != null) {
            System.out.println(p.toString());
        }
    }

    //    Data insertion :
//    @Test
    public void testAddManyPostsSequential() {
        List<User> userList = dumpDao.getUsers(10, 200);
        Random random = new Random();
        for (int x = 0; x < userList.size(); x++) {
            List<PostComment> comments = new ArrayList<>();
            for (int y = 0; y <= random.nextInt(5); y++) {
                String useID = userList.get(random.nextInt(userList.size() - 1)).getId().toString();
                PostComment postComment = new PostComment(DumpData.getDate(), DumpData.getNote(), useID);
                comments.add(postComment);
            }

            Post post = new Post(
                    userList.get(x).getId().toString(),
                    DumpData.getBloodGroup(),
                    dumpDao.getAddressString("PRESENT"),
                    DumpData.getHospitalName(),
                    DumpData.getHospitalAddress(),
                    DumpData.getGender(),
                    DumpData.getPatientDescription(),
                    "20-10-10",
                    DumpData.getDate(),
                    DumpData.getQuantity(),
                    DumpData.getPhoneNumber(),
                    "0",
                    DumpData.getNote(),
                    "NO",
                    "SON",
                    DumpData.getNote(),
                    "NA",
                    DumpData.getNote(),
                    comments);

            dao_post_i.savePost(post);
        }
    }

    //    @Test
    public void testAddManyPostsRandom() {
        List<User> userList = dumpDao.getUsers(10, 200);
        Random random = new Random();
        for (int x = 0; x < 200; x++) {
            List<PostComment> comments = new ArrayList<>();
            for (int y = 0; y <= random.nextInt(5); y++) {
                String useID = userList.get(random.nextInt(userList.size() - 1)).getId().toString();
                PostComment postComment = new PostComment(DumpData.getDate(), DumpData.getNote(), useID);
                comments.add(postComment);
            }

            String useID = userList.get(random.nextInt(userList.size() - 1)).getId().toString();
            Post post = new Post(
                    useID,
                    DumpData.getBloodGroup(),
                    dumpDao.getAddressString("PRESENT"),
                    DumpData.getHospitalName(),
                    DumpData.getHospitalAddress(),
                    DumpData.getGender(),
                    DumpData.getPatientDescription(),
                    "20-10-10",
                    DumpData.getDate(),
                    DumpData.getQuantity(),
                    DumpData.getPhoneNumber(),
                    "0",
                    DumpData.getNote(),
                    "NO",
                    "SON",
                    DumpData.getNote(),
                    "NA",
                    DumpData.getNote(),
                    comments);

            dao_post_i.savePost(post);
        }
    }


    public void storeUserID(String userID) {
        try {
            FileWriter myWriter = new FileWriter("post_userID.txt");
            myWriter.write(userID);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getUserID() {
        String id = "";
        try {
            File myObj = new File("post_userID.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                id = data;
//                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return id;
    }

    public void storeID(String id) {
        try {
            FileWriter myWriter = new FileWriter("post_ID.txt");
            myWriter.write(id);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getID() {
        String id = "";
        try {
            File myObj = new File("post_ID.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                id = data;
//                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return id;
    }


}// class
