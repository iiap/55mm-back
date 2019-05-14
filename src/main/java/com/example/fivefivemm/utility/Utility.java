package com.example.fivefivemm.utility;

import com.example.fivefivemm.entity.user.User;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 工具类
 *
 * @author tiga
 * @version 1.0
 * @since 2019年5月14日17:13:28
 */
public class Utility {

    /**
     * md5加密算法
     *
     * @param password 密码
     * @return 加密后的密码
     */
    public static String md5(String password) {
        if (password != null && password.length() != 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                //需要加密的信息
                byte[] input = password.getBytes();
                //加密过的信息
                byte[] output = messageDigest.digest(input);
                //将md5处理后的output结果转出字符串
                //利用Base64算法转出字符串
                return Base64.encodeBase64String(output);
            } catch (NoSuchAlgorithmException e) {
                System.out.println("加密失败");
                return "";
            }
        } else {
            return "";
        }
    }

//    /**
//     * 生成10位随机密码
//     *
//     * @return 生成的随机密码
//     */
//    public static String randomPassword() {
//        String val = "";
//        Random random = new Random();
//        //length为几位密码
//        for (int i = 0; i < 10; i++) {
//            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
//            //输出字母还是数字
//            if ("char".equalsIgnoreCase(charOrNum)) {
//                //输出是大写字母还是小写字母
//                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
//                val += (char) (random.nextInt(26) + temp);
//            } else if ("num".equalsIgnoreCase(charOrNum)) {
//                val += String.valueOf(random.nextInt(10));
//            }
//        }
//        return val;
//    }

    /**
     * 业务Json构造
     */
    public static String ResultBody(int status, String message, Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        if (message != null) {
            jsonObject.put("message", message);
        }
        if (data != null) {
            jsonObject.put("data", data);
        }
        return jsonObject.toString();
    }

//    /**
//     * 单个博客信息Json构造
//     */
//    public static Map BlogBody(Blog blog) {
//        Map<String, Object> blogMap = new HashMap<>();
//        Map<String, Object> authorMap = new HashMap<>();
//        JSONArray jsonArray = new JSONArray();
//        blogMap.put("blogId", blog.getBlogId());
//        blogMap.put("title", blog.getTitle());
//        blogMap.put("content", blog.getContent());
//        blogMap.put("summary", blog.getSummary());
//        blogMap.put("createTime", blog.getCreateTime().toString());
//        if (blog.getLastModifyTime() != null) {
//            blogMap.put("lastModifyTime", blog.getLastModifyTime().toString());
//        } else {
//            blogMap.put("lastModifyTime", blog.getLastModifyTime());
//        }
//        blogMap.put("approve", blog.getApprove());
//        blogMap.put("browse", blog.getBrowse());
//        blogMap.put("collect", blog.getCollect());
//        authorMap.put("name", blog.getAuthor().getName());
//        authorMap.put("userId", blog.getAuthor().getUserId());
//        blogMap.put("author", authorMap);
//        Set<Remark> remarkSet = blog.getRemarks();
//        //对评论集合进行排序
//        List<Remark> remarkList = new ArrayList<>(remarkSet);
//        Collections.sort(remarkList, new Comparator<Remark>() {
//            @Override
//            public int compare(Remark o1, Remark o2) {
//                return o1.getRemarkId() > o2.getRemarkId() ? -1 : 1;
//            }
//        });
//        for (Remark remark : remarkList) {
//            jsonArray.add(RemarkBody(remark));
//        }
//        blogMap.put("remarks", jsonArray);
//        return blogMap;
//    }

//    /**
//     * 多个博客信息Json构造
//     */
//    public static JSONArray BlogListBody(List<Blog> blogList) {
//        if (blogList != null && blogList.size() > 0) {
//            JSONArray blogArray = new JSONArray();
//            for (Blog blog : blogList) {
//                blogArray.add(BlogBody(blog));
//            }
//            return blogArray;
//        } else {
//            return new JSONArray();
//        }
//    }

    /**
     * 单个用户信息Json构造
     */
    public static Map userBody(User user) {
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("userId", user.getUserId());
        userMap.put("name", user.getName());
        userMap.put("sex", user.getSex());
        userMap.put("age", user.getAge());
        userMap.put("email", user.getEmail());
        userMap.put("phone", user.getPhone());
        userMap.put("qq", user.getQq());
        userMap.put("introduction", user.getIntroduction());
        userMap.put("weChat", user.getWeChat());
        userMap.put("avatar", user.getAvatar());
        userMap.put("type", user.getType());
        if (user.getBirthday() != null) {
            userMap.put("birthday", user.getBirthday().toString().substring(0, 10));
        }
        return userMap;
    }

    /**
     * 头像地址构造
     */
    private static String avatarAddress(String serverAddress, String fileName) {
        return serverAddress + "avatar/" + fileName;
    }

    /**
     * 博客图片地址构造
     */
    public static String blogAddress(String serverAddress, String fileName) {
        return serverAddress + "blog/" + fileName;
    }

    /**
     * 根据生日计算年龄
     *
     * @param birthday 生日
     * @return 年龄
     */
    public static int getAgeByBirth(Date birthday) {
        int age;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);
            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
            return 0;
        }
    }

    /**
     * 获取现在时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDate() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return ft.format(dNow);
    }

    /**
     * 保存头像
     *
     * @param file 头像图片
     * @return 头像图片地址
     */
    public static String saveAvatar(MultipartFile file) {
        if (file == null) {
            return null;
        }
        String fileName = UUID.randomUUID() + file.getOriginalFilename();
        try {
            file.transferTo(new File(Constants.avatarPath + fileName));
            return avatarAddress(Constants.serverAddress, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
