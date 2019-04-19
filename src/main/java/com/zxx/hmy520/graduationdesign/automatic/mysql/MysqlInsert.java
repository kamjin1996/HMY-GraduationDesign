package com.zxx.hmy520.graduationdesign.automatic.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author kam
 * @Description: 测试数据插入
 * @date 2018/5/11 14:50
 */
public class MysqlInsert {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        final String url = "jdbc:mysql://192.168.2.200:3306/xdpx_quote";
        final String name = "com.mysql.jdbc.Driver";
        final String user = "root";
        final String password = "123456";
        Connection conn = null;
        Class.forName(name);//指定连接类型
        conn = DriverManager.getConnection(url, user, password);//获取连接
        if (conn != null) {
            System.out.println("获取连接成功");
            insert(conn);
        } else {
            System.out.println("获取连接失败");
        }
    }

    public static void insert(Connection conn) {
        // 开始时间
        Long begin = System.currentTimeMillis();
        // sql前缀
        String prefix =
                "INSERT INTO `enquiry_part` ( `enquiry_id`, `sub_id`, `parent_id`, `sub_name`, `parent_name` ) " +
                        "VALUES";

        try {
            // 保存sql后缀
            StringBuffer suffix = new StringBuffer();
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            // 比起st，pst会更好些
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句
            // 外层循环，总提交事务次数
            int enq = 30;
            for (int i = 1; i <= 200; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= 10000; j++) {
                    enq = enq + 1;
                    // 构建SQL后缀
                    UUID uuid = UUID.randomUUID();
                    String suffixStr = "( " + enq + ", 6, 1, 'xxxxxx', 'xxxxxxxxxxx' ),";
//                    String suffixStr = "( '" + uuid.toString() + "', '" + uuid.toString() + "', '心动配讯～博光广告15158199806', '1', '中国', '浙江', '杭州', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eqHzJqBQX9OaJveU6gYakib7h7svsnyFqGntFF2m7OxHRK0crv9Y4rTC9TGibehOAZC9o8eu5nu8W0g/0', '4d0f0d3f551b1ccab24b542f76a9fe', '15158199806', 330100, '杭州', '2018-02-08 09:54:57', '2018-04-18 20:46:29'),";
                    suffix.append(suffixStr);
                }
                // 构建完整SQL
                String sql = prefix + suffix.substring(0, suffix.length() - 1);
                // 添加执行SQL
                pst.addBatch(sql);
                // 执行操作
                pst.executeBatch();
                // 提交事务
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 头等连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        // 耗时
        System.out.println("数据插入花费时间 : " + (end - begin) / 1000 + " service");
        System.out.println("插入完成");
    }

}
