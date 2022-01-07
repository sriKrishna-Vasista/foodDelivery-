<p class="lead">Grocery Items</p>

<div class="list-group">
	<c:forEach items="${categories }" var="category">
		<a href="/show/category/${category.id }/products" class="list-group-item" id="a_${category.name }">${category.name }</a> 
	</c:forEach>
</div>

<p class="lead">Location Filter</p>
<div class="list-group">
	<c:forEach items="${cities }" var="city">
		<a href="/show/city/${city }/products" class="list-group-item" id="a_${city }">${city }</a> 
	</c:forEach>
</div>