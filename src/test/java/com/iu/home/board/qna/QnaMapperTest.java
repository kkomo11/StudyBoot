package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.iu.home.util.Pager;

@SpringBootTest
//@Rollback(true)
@Transactional
class QnaMapperTest {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	QnaVO qnaVO;
	
	//@Test
	void test() throws Exception {
		Pager pager = new Pager();
		pager.getRow();
		List<QnaVO> ar = qnaMapper.getList(pager);
		log.info("List : {} , size : {}", ar, ar.size());
		assertNotEquals(0, ar.size());
	}

	@Test
	void setQna() throws Exception {
		
		qnaVO = new QnaVO();
		qnaVO.setContents("Contents4");
		qnaVO.setTitle("title4");
		qnaVO.setWriter("writer4");
		int result = qnaMapper.setQna(qnaVO);
		assertEquals(1, result);
	}
	
	//@BeforeAll
	static void beforeAll() {
		System.out.println("전제 Test 실행 전");
	}
	
	//@AfterAll
	static void afterAll() {
		System.out.println("전체 Test 실행 후");
	}
	
	//@Test
	void test2() {
		log.info("Test2 Case");
	}
	
	//@BeforeEach
	void beforeEach() {
		
	}
	
	//@AfterEach
	void afterEach() {
	}
}
