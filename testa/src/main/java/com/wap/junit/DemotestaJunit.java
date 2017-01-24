package com.wap.junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.wap.entity.Demotesta;
import com.wap.page.DemotestaPage;
import com.wap.service.DemotestaService;



/*
 * @TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true) 
 * transactionManager的默认取值是"transactionManager"，
 * defaultRollback的默认取值是true，当然，你也可以改成false。
 * true表示测试不会对数据库造成污染,false的话当然就会改动到数据库中了。
 * 在方法名上添加@Rollback(false)表示这个测试用例不需要回滚。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class DemotestaJunit {
	private static Object id;
	@Autowired
	private DemotestaService<Demotesta> demotestaService;
	

	@Test
	public void testAdd(){
		try {
			Demotesta demotesta = new Demotesta();
			demotestaService.add(demotesta);
			id = demotesta.getId();
			System.out.println("-testAdd-----id---------"+id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testList(){
		try {
			DemotestaPage demotestaPage = new DemotestaPage();
			List<Demotesta> demotestas = demotestaService.queryByList(demotestaPage);
			for(Demotesta e:demotestas){
				System.out.println(e.getName());
			}
			System.out.println("----testList----------");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testDel(){
		try {
			demotestaService.delete(id);
			System.out.println("---testDel-----------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
