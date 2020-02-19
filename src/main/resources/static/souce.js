function ajax(url, parArr) {
	console.log(JSON.stringify(parArr));
	$(function() {
		$.ajax({
			// 请求方式
			type : "POST",
			// 请求的媒体类型
			contentType : "application/json;charset=UTF-8",
			// 请求地址
			url : url,
			// 数据，json字符串
			data : JSON.stringify(parArr),
			// 请求成功
			success : function(json) {
				console.log(json);
				location.reload();
				return json;
			},
			// 请求失败，包含具体的错误信息
			error : function(e) {
				console.log(e.status);
				console.log(e.responseText);
			}
		});
	});

}

function onbth(o) {
	console.log(o);
	var parArr = {};
	parArr.deptId = o;
	console.log(JSON.stringify(parArr));
	$(function() {
		$.ajax({
			// 请求方式
			type : "POST",
			// 请求的媒体类型
			contentType : "application/json;charset=UTF-8",
			// 请求地址
			url : "/dept/api/findDept",
			// 数据，json字符串
			data : JSON.stringify(parArr),
			// 请求成功
			success : function(json) {
				console.log(json);
				modifyshow(json)

			},
			// 请求失败，包含具体的错误信息
			error : function(e) {
				console.log(e.status);
				console.log(e.responseText);
			}
		});
	});
}
function modifyshow(json) {
	var tab = new mdui.Tab('#example4-tab');
	mdui.JQ('#example-4').on('open.mdui.dialog', function() {
		tab.handleUpdate();
	});

	$("#deptId").attr("value", json.deptId);
	$("#parentId").attr("value", json.parentId);
	$("#deptName").attr("value", json.deptName);
	$("#orderNum").attr("value", json.orderNum);
}
function confirm() {
	dialog.addEventListener('confirm.mdui.dialog', function() {
		console.log('confirm');
	});
}

function Confirm_revision() {
	var deptId = $(" #deptId ").val()
	var parentId = $(" #parentId ").val()
	var deptName = $(" #deptName ").val()
	var orderNum = $(" #orderNum ").val()
	var url = "/dept/api/update";
	var parArr = {};
	parArr.deptId = deptId;
	parArr.parentId = parentId;
	parArr.deptName = deptName;
	parArr.orderNum = orderNum;
	console.log(JSON.stringify(parArr));
	ajax(url, parArr);
}
