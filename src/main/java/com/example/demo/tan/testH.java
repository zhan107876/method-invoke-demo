package com.example.demo.tan;

/**
 * hibernate 删除例子
 * 由于没有 导入相关包，因此注释掉
 *
 * @Author XZ.Tan
 * @Date: 2021/1/9 11:30
 * @Version 1.0
 */
public class testH {
    public static void main(String[] args) {

//        Session session = sessionFactory.getCurrentSession();
//        //删除
//        TestT<TestBean> testT = new TestT();
//        TestBean testBean = new TestBean();
//        testBean.setName("zhan");
//        testBean.setCode("hhaa");
//
//        /*
//         * @Date: 2021/1/9 11:37
//         * 用session删除 （这种方式没有设置id 删除不了）
//         */
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        session.delete(testBean);
//        session.getTransaction().commit();
//
//        /*
//         * @Date: 2021/1/9 11:37
//         * 采用自己 构造删除HQL的方法删除
//         */
//        List<Object> paramList = new ArrayList<>();
//        String deleteHql = testT.createDeleteHql(testBean, paramList);
//
//        // 构造hibernate查询
//        Query query = session.createQuery(deleteHql);
//        if (paramList != null) {
//            int size = paramList.size();
//            for (int i = 0; i < size; i++) {
//                query.setParameter(i, paramList.get(i));
//            }
//        }
//        // 执行删除操作
//        query.executeUpdate();
    }

}