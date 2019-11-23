package com.wky.oa.action;

import com.opensymphony.xwork2.util.ValueStack;
import com.wky.oa.base.BaseAction;
import com.wky.oa.domain.Role;
import com.wky.oa.service.IRoleService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller
//spring 多例设置
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {

    @Resource
    private IRoleService iRoleService;


    /**
     * 岗位列表查询
     *
     * @return
     */
    public String list(){
        List<Role> roleList = iRoleService.findAll();

        ValueStack valueStack = getValueStack();

        valueStack.set("list",roleList);

        return "list";
    }

    /**
     * 删除岗位
     * @return
     */
    public String delete(){
        iRoleService.delete(model);
        return  "toList";
    }

    public String update(){
        Role role = iRoleService.getById(model.getId());
        getValueStack().push(role);
        return  "editUI";
    }


    /**
     * 跳转到添加页面
     */
    public String addUI(){
        return "addUI";
    }

    /**
     * 添加岗位
     */
    public String add(){
        iRoleService.save(model);
        return "toList";
    }

    /**
     * 编辑岗位
     */
    public String edit(){
        iRoleService.save(model);
        return "toList";
    }
}
