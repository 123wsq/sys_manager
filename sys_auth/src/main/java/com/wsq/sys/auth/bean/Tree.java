package com.wsq.sys.auth.bean;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	private String id;
	private String text;
	private boolean checked;
	private String  menuParId;
	private String url;
	private Attributes attributes;
	public List <Tree> children = new ArrayList<Tree>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getMenuParId() {
		return menuParId;
	}
	public void setMenuParId(String menuParId) {
		this.menuParId = menuParId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public List<Tree> getChildren() {
		return children;
	}
	public void setChildren(List<Tree> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Tree [id=" + id + ", text=" + text + ", checked=" + checked
				+ ", menuParId=" + menuParId + ", url=" + url + ", attributes="
				+ attributes + ", children=" + children + "]";
	}
}
