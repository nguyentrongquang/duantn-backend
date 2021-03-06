package duantn.backend.controller.superAdmin;

import duantn.backend.model.dto.input.StaffInsertDTO;
import duantn.backend.model.dto.input.StaffUpdateDTO;
import duantn.backend.model.dto.output.StaffOutputDTO;
import duantn.backend.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/super-admin")
public class StaffsManager {
    final
    StaffService staffService;

    public StaffsManager(StaffService staffService) {

        this.staffService = staffService;
    }


    @GetMapping("/staffs")
    public List<StaffOutputDTO> listStaffs(@RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) Integer limit) {
        return staffService.listStaff(page, limit);
    }

    //    thêm nhân viên	Post/super-admin/staffs
    @PostMapping("/staffs")
    public ResponseEntity<?> insertStaff(@RequestBody StaffInsertDTO staffInsertDTO) {
        return staffService.insertStaff(staffInsertDTO);
    }

    //    cập nhật thông tin nhân viên	Put/super-admin/staffs
    @PutMapping("/staffs")
    public ResponseEntity<?> updateStaff(@RequestBody StaffUpdateDTO staffUpdateDTO) {
        return staffService.updateStaff(staffUpdateDTO);
    }

    //    block nhân viên	GET/super-admin/staffs/block/{id}
    @DeleteMapping("/staffs/{id}")
    public ResponseEntity<String> blockStaff(@PathVariable Integer id) {
        return staffService.blockStaff(id);
    }

    //    active nhân viên	DELETE/super-admin/staffs/block/{id}
    @GetMapping("/staffs/active/{id}")
    public ResponseEntity<String> activeStaff(@PathVariable Integer id) {
        return staffService.activeStaff(id);
    }

    //    tìm kiếm nhân viên bằng email	hoặc sđt hoặc họ tên GET/super-admin/staffs?search={search}
    @GetMapping(value = "/staffs", params = "search")
    public List<StaffOutputDTO> searchStaff(@RequestParam String search,
                                            @RequestParam(required = false) Integer page,
                                            @RequestParam(required = false) Integer limit) {
        return staffService.searchStaff(search, page, limit);
    }


    //    xem thông tin nhân viên	GET/super-admin/staffs/{id}
    @GetMapping("/staffs/{id}")
    public ResponseEntity<?> findOneStaff(@PathVariable Integer id) {
        return staffService.findOneStaff(id);
    }

}
