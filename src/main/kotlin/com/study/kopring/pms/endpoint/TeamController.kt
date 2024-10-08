package com.study.kopring.pms.endpoint

import com.study.kopring.common.vo.PageResponse
import com.study.kopring.pms.board.TeamMemberService
import com.study.kopring.pms.board.TeamService
import com.study.kopring.pms.board.vo.request.PTeam
import com.study.kopring.pms.board.vo.request.PTeamMember
import com.study.kopring.pms.board.vo.response.RTeam
import com.study.kopring.pms.board.vo.response.RTeamMember
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TeamController(
    private val teamService: TeamService,
    private val teamMemberService: TeamMemberService
){

    @PostMapping("/pms/v1/team")
    fun add(@RequestBody pTeam: PTeam):ResponseEntity<Void> {
        teamService.add(pTeam)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/pms/v1/team")
    fun get(@RequestParam("size", defaultValue = "10") size:Int,
            @RequestParam("page", defaultValue = "0") page:Int
    ):ResponseEntity<PageResponse<RTeam>> {
        val result:PageResponse<RTeam> = teamService.get(PageRequest.of(page, size))
        return ResponseEntity.ok(result)
    }

    @PostMapping("/pms/v1/teamMember")
    fun add(@RequestBody pTeamMember: PTeamMember):ResponseEntity<Void> {
        teamMemberService.add(pTeamMember)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/pms/v1/teamMember/{teamSeq}")
    fun teamMemberGet(@RequestParam("size", defaultValue = "10") size:Int,
                      @RequestParam("page", defaultValue = "0") page:Int,
                      @PathVariable("teamSeq") teamSeq:Long
    ):ResponseEntity<PageResponse<RTeamMember>> {
        val result:PageResponse<RTeamMember> = teamMemberService.get(PageRequest.of(page, size), teamSeq)
        return ResponseEntity.ok(result)
    }
}