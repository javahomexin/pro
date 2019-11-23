package com.wky.oa.action;

import com.wky.oa.base.BaseAction;
import com.wky.oa.domain.Department;
import com.wky.oa.service.IDepartmentService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department> {

    private Long parentId;//属性驱动

    @Resource
    private IDepartmentService iDepartmentService;

    /**
     * 列表
     * @return
     */
    public String list(){

        List<Department> departmentList = iDepartmentService.findAll();

        getValueStack().set("list",departmentList);
        return "list";
    }

    /**
     * 删除
     * @return
     */
    public String delete(){

        iDepartmentService.delete(model.getId());

        return "toList";
    }


    public String addUI(){

        //获取列表
        List<Department> departmentList  = iDepartmentService.findAll();

        getValueStack().set("list",departmentList);

        return "addUI";
    }

    /**
     *  跳转编辑页面
     * @return
     */
    public String editUI(){

        //获取列表
        List<Department> departmentList  = iDepartmentService.findAll();

        Department department = iDepartmentService.getById(model.getId());

        getValueStack().set("list",departmentList);

        getValueStack().push(department);

        if(department.getParent() != null){
            parentId = department.getParent().getId();
        }

        return "editUI";
    }

    public String add(){

        if(parentId != null){
            //存在父级
            Department department = iDepartmentService.getById(parentId);
            model.setParent(department);
        }else {
            model.setParent(null);
        }
        iDepartmentService.save(model);
        return "toList";
    }

    public String edit(){

        Department department = iDepartmentService.getById(model.getId());
        
        if(parentId != null){

        }else {

        }
        iDepartmentService.update(model);
        return "toList";
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
