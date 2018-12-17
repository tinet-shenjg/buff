package com.shenjg.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页数据对象的统一封装
 *
 * @param <T> 数据集对象泛型
 * @author shenjg
 * @date 2018/03/07
 */
public class PageData<T> {
	public static final int DEFAULT_PAGE_SIZE = 15;
	public static final int MIN_PAGE_SIZE = 10;
	public static final int MAX_PAGE_SIZE = 100;
	public static final int DEFAULT_PAGE_OFFSET = 0;

	/**
	 * 当前页第一条数据的位置,从0开始则表示当前页为第1页
	 */
	private int start;

	/**
	 * 当前页码
	 */
	private int currentPageNo;

	/**
	 * 每页的记录数
	 */
	private int pageSize = 15;

	/**
	 * 当前页中存放的记录
	 */
	private List<T> data;

	/**
	 * 总记录数
	 */
	private int totalCount;

	private Map<String,Object> countMap = new HashMap<>();

	/**
	 * 构造方法，只构造空页
	 */
	public PageData() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>());
	}

	/**
	 * 构造方法，只构造空页,初始化pagesize
	 */
	public PageData(int pageSize) {
		this(0, 0, pageSize, new ArrayList<T>());
	}


	/**
	 * 默认构造方法
	 *
	 * @param start 本页数据在数据库中的起始位置
	 * @param totalCount 数据库中总记录条数
	 * @param pageSize 本页容量
	 * @param data 本页包含的数据
	 */
	public PageData(int start, int totalCount, int pageSize, List<T> data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalCount;
		this.data = data;
	}

	/**
	 * 默认构造方法
	 *
	 * @param start 本页数据在数据库中的起始位置
	 * @param totalCount 数据库中总记录条数
	 * @param pageSize 本页容量
	 * @param data 本页包含的数据
	 * @param countMap 复杂统计项
	 */
	public PageData(int start, int totalCount, int pageSize, List<T> data,Map countMap) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalCount;
		this.data = data;
		this.countMap = countMap;
	}

	/**
	 * 默认构造方法,不分页查询全部
	 *
	 * @param list 包含的数据
	 */
	public PageData(List<T> list) {
		if (list != null) {
			this.pageSize = 0;
			this.start = 0;
			this.totalCount = list.size();
			this.data = list;
		}
	}

	/**
	 * 取数据库中包含的总记录数
	 */
	public int getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 设置数据库中包含的总记录数
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 取总页数。
	 */
	public int getTotalPageCount() {
		if (totalCount == 0) {
			return 0;
		} else {
			return ((totalCount - 1) / pageSize) + 1;
		}
	}

	/**
	 * 取每页数据容量
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 取当前页码,页码从1开始
	 */
	public int getCurrentPageNo() {
		if (start == 0) {
			currentPageNo = 1;
		} else {
			int curPage = (start / pageSize) + 1;
			if (curPage > this.getTotalPageCount()) {
				curPage = this.getTotalPageCount();
			}
			currentPageNo = curPage;
		}
		return currentPageNo;
	}

	/**
	 * 是否有下一页
	 */
	public boolean hasNextPage() {
		return (this.getCurrentPageNo() < this.getTotalPageCount());
	}

	/**
	 * 是否有上一页
	 */
	public boolean hasPreviousPage() {
		return (this.getCurrentPageNo() > 1);
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public Map<String, Object> getCountMap() {
		return countMap;
	}

	public void setCountMap(Map<String, Object> countMap) {
		this.countMap = countMap;
	}

	public int getStart() {
		return start;
	}
}
