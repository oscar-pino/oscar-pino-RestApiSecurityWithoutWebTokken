package api.security.dto;

public class CategoryDTO {

	private Long categoryId;

	private String name;	

	private String description;

	public CategoryDTO() {
	}

	public CategoryDTO(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "CategoryDTO [CategoryDTOId=" + categoryId + ", name=" + name + ", description=" + description + "]";
	}	
}
