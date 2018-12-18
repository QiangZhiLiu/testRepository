package com.shop.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shop.customer.CustomBean;
import com.shop.domain.Product;
import com.shop.exception.MyException;
import com.shop.service.ProductService;
import com.sun.org.apache.regexp.internal.recompile;
@Controller
public class ProductController{
	@Autowired
	private ProductService productservice;
	/*@RequestMapping(value="/list",method=RequestMethod.GET)*/

	@RequestMapping("/list")
	public ModelAndView getList() throws MyException
    {
		
		
		//需求：假设 根据id查询商品信息，但是没有查询到信息  （异常）
		if(true)
		{
		     throw  new MyException("对不起，商品没有查到~~");	
		}
		
		
		
		int i = 1/0;
		
		//Airxxxxx => Exception 
		
		
	
        List<Product> list = productservice.getProductList();	
    
    	ModelAndView  mv = new ModelAndView();
    	mv.setViewName("productList");  // 逻辑视图(假的)    物理视图  （/WEB-INF/productList.jsp）
    
    	// addObject(String key,Object Value)  =>该用法和request用户一样
    	
    	mv.addObject("productList", list);
    	
    	return mv;
    }
	/*@RequestMapping(value="/itemEdit")
	public ModelAndView getProductById(HttpServletRequest req,
			HttpServletResponse response,
			HttpSession ss)
	{
		String id = req.getParameter("id");
		Product product = productservice.getProductById(Integer.parseInt(id));
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("item", product);
		
		mv.setViewName("productItem");
		
	   return mv; 	
	}*/

	
	@RequestMapping(value="/itemEdit/{id}")
	public ModelAndView getProductById(HttpServletRequest req,
			HttpServletResponse response,
			HttpSession ss,@PathVariable("id") Integer id)
	{
		/*String id = req.getParameter("id");
		Product product = productservice.getProductById(Integer.parseInt(id));
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("item", product);
		
		mv.setViewName("productItem");*/

		
         
		Product product = productservice.getProductById(id);
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("item", product);
		
		mv.setViewName("productItem");
	   return mv; 	
	}
	
	// 修改商品功能
	/*@RequestMapping(value="/updateProduct")
	public ModelAndView updateProduct(Integer id,
			String name,
			float price,
			String detail)
	{
		
		Product product  = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setDetail(detail);
		
		
		product.setCreatetime(new Date());
		//执行修改功能
		
		productservice.update(product);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
	    return mv;     	
	}*/
	
	
	@RequestMapping(value="/updateProduct")
	public ModelAndView updateProduct(MultipartFile pictureFile,Product product) throws IllegalStateException, IOException
	{

		
		
	//1.获取到客户端提交过来的完整文件名称
		String originalFilename = pictureFile.getOriginalFilename();
		System.out.println("originalFilename=============:"+originalFilename);
		
		
		/**
		 * 
		 * struts2地址.txt 
		 * 
		 * asjaksjkasj  => UUID.randomUUID().toString()  +.txt
		 */
		String newFileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
		
		System.out.println(newFileName);
		
		
		// 将处理好的图片进行上传 
		
		// 将本地文件上传到 图片服务器的磁盘上
		
		pictureFile.transferTo(new File("E:\\images\\"+newFileName));
		
		// 将图片的路径保存一份到 数据库中  （将来网站可以显示）
		
		product.setPic(newFileName);
		
		
		
		
		
		
		//product.setCreatetime(new Date());
		//执行修改功能
		
		productservice.update(product);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("test");
	    return mv;     	
	}
	
	@RequestMapping(value="/query")
	public ModelAndView query(CustomBean cus)
	{
	  
		return null;
	}
	
	
	
	//  批量删除
	
	@RequestMapping(value="/deleteAll")
	public ModelAndView deleteAll(CustomBean vo)
	{
	   return null;	
	}
	
     @RequestMapping(value="/updateAll")
	public ModelAndView updateAll(CustomBean vo)
	{
    System.out.println("products========================================="+vo);
   //  System.out.println(vo.getProducts());
	  return  null;	
	}
     @RequestMapping(value="/sendjson")
     
     /*
      * @RequestBody 就是帮我们在 json格式数据和java实体之间进行转换
      * 
      *             前提: ajax 中json的key必须要和java实体中 字段名称一致  
      * */
     
     
    /* public ModelAndView sendjson(@RequestBody Product product)
     {
    	 System.out.println(product);
    	return null; 
     }*/

     
     @ResponseBody
     public Product sendjson(@RequestBody Product product)
     {
    	 System.out.println(product);
    	 
    	return product; 
     }
}
