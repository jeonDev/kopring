package com.study.kopring.pms.board.entity

import com.study.kopring.pms.board.vo.type.WorkType
import com.study.kopring.pms.member.entity.Member
import jakarta.persistence.*

@Entity
@Table(name = "WORK")
class Work(

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WORK_SEQ")
    var id:Long = 0L

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_SEQ")
    lateinit var board: Board

    @Column(name = "PROGRESS_RATE")
    var progressRate: Int = 0

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WRITER_ID_SEQ")
    lateinit var writerMember: Member

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID_SEQ")
    lateinit var managerMember: Member

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    var workType: WorkType = WorkType.REQUEST
}
