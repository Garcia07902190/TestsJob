package com.garcia.testshop;

import com.garcia.testshop.controller.ShopCcontroller;
import com.garcia.testshop.entity.Product;
import com.garcia.testshop.service.ShopService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * The type Test shop application tests.
 */
@SpringBootTest
class TestShopApplicationTests {

	@InjectMocks
	private ShopCcontroller shopData;

	@Mock
	private ShopService serviceSh;


	/**
	 * Execute list product test.
	 */
	@Test
	void executeListProductTest() {
		when(serviceSh.executeListAllProduct()).thenReturn(new ArrayList<>());
		ResponseEntity<List<Product>> rs = shopData.executeListProduct();
		assertNotNull(rs);
	}

	/**
	 * Execute create product test.
	 */
	@Test
	void executeCreateProductTest(){
		ResponseEntity<?> rs = shopData.executeCreateProduct(addProduct());
		assertEquals(rs.getBody(), "Succes");
	}

	/**
	 * Execute delete product test.
	 */
	@Test
	void executeDeleteProductTest(){

		when(serviceSh.executeGetProduct(Mockito.anyLong())).thenReturn(getDataProduct());
		when(serviceSh.executeDeleteProduct(Mockito.anyLong())).thenReturn("Succes");
		ResponseEntity<?> rs = shopData.executeDeleteProduct(2L);
		assertEquals(rs.getBody(), "Succes");
	}

	/**
	 * Execute get page product test.
	 */
	@Test
	void executeGetPageProductTest(){
		final Pageable pagData= PageRequest.of(1,5);
		when(serviceSh.executeFindProduct(pagData)).thenReturn(getDetailPage());

		ResponseEntity<?> rs = shopData.executeGetPageProduct(1);
		assertEquals(rs.getStatusCodeValue(), 202);
	}


	/**
	 * Execute update product test.
	 */
	@Test
	void executeUpdateProductTest(){
		when(serviceSh.executeGetProduct(Mockito.anyLong())).thenReturn(getDataProduct());

		ResponseEntity<?> rs = shopData.executeUpdateProduct(addProduct());
		assertEquals(rs.getStatusCodeValue(), 202);
	}

	private Page<Product> getDetailPage() {
		Page<Product> pg=new Page<Product>() {
			@Override
			public int getTotalPages() {
				return 0;
			}

			@Override
			public long getTotalElements() {
				return 0;
			}

			@Override
			public <U> Page<U> map(Function<? super Product, ? extends U> converter) {
				return null;
			}

			@Override
			public int getNumber() {
				return 0;
			}

			@Override
			public int getSize() {
				return 0;
			}

			@Override
			public int getNumberOfElements() {
				return 0;
			}

			@Override
			public List<Product> getContent() {
				List<Product> listProd= new ArrayList<>();
				for (int i=0; i<10; i++) {
					Product pr = new Product();
					pr.setId(100L+i);
					pr.setNombre("Monitor Gammer 32 pulgadas");
					pr.setDescription("Monitor samsung 19 pulgadas 1080");
					pr.setPrecio(4500);
					listProd.add(pr);
				}
				return listProd;
			}

			@Override
			public boolean hasContent() {
				return false;
			}

			@Override
			public Sort getSort() {
				return null;
			}

			@Override
			public boolean isFirst() {
				return false;
			}

			@Override
			public boolean isLast() {
				return false;
			}

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public boolean hasPrevious() {
				return false;
			}

			@Override
			public Pageable nextPageable() {
				return null;
			}

			@Override
			public Pageable previousPageable() {
				return null;
			}

			@Override
			public Iterator<Product> iterator() {
				return null;
			}
		};

		return pg;
	}


	private Product addProduct() {

		final  Product product= new Product();
		product.setId(100L);
		product.setNombre("Monitor Gammer 32 pulgadas");
		product.setDescription("Monitor samsung 19 pulgadas 1080");
		product.setPrecio(4500);

	return product;
	}
	private Optional<Product> getDataProduct() {
		Product prod= new Product();
		prod.setId(100L);
		prod.setNombre("Monitor Gammer 32 pulgadas");
		prod.setDescription("Monitor samsung 19 pulgadas 1080");
		prod.setPrecio(4500);

		return Optional.of(prod);
	}

}
