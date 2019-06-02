package com.guardians.cmpe272.project.json;

import java.util.List;

import org.springframework.data.domain.Sort;

public class PageJson {

	private List<ListingJson> content;
	
	private boolean last;
	
	private long totalElements;
	
	private int TotalPages;
	
	private int size;
	
	private int number;
	
	private Sort sort;
	
	private boolean first;
	
	private int numberOfElements;

	/**
	 * 
	 */
	public PageJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param content
	 * @param last
	 * @param totalElements
	 * @param totalPages
	 * @param size
	 * @param number
	 * @param sort
	 * @param first
	 * @param numberOfElements
	 */
	public PageJson(List<ListingJson> content, boolean last, long totalElements, int totalPages, int size, int number,
			Sort sort, boolean first, int numberOfElements) {
		super();
		this.content = content;
		this.last = last;
		this.totalElements = totalElements;
		TotalPages = totalPages;
		this.size = size;
		this.number = number;
		this.sort = sort;
		this.first = first;
		this.numberOfElements = numberOfElements;
	}

	/**
	 * @return the content
	 */
	public List<ListingJson> getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(List<ListingJson> content) {
		this.content = content;
	}

	/**
	 * @return the last
	 */
	public boolean isLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(boolean last) {
		this.last = last;
	}

	/**
	 * @return the totalElements
	 */
	public long getTotalElements() {
		return totalElements;
	}

	/**
	 * @param totalElements the totalElements to set
	 */
	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return TotalPages;
	}

	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		TotalPages = totalPages;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the sort
	 */
	public Sort getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(Sort sort) {
		this.sort = sort;
	}

	/**
	 * @return the first
	 */
	public boolean isFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(boolean first) {
		this.first = first;
	}

	/**
	 * @return the numberOfElements
	 */
	public int getNumberOfElements() {
		return numberOfElements;
	}

	/**
	 * @param numberOfElements the numberOfElements to set
	 */
	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}
}
