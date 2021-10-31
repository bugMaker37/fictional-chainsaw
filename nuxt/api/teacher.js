import request from '@/utils/request'
export default {
  //分页讲师查询
  getTeacherList(page,limit) {
    return request({
      url: `/eduservice/teacherFront/getTeacherFrontList/${page}/${limit}`,
      method: 'post'
    })
  },
  getById(teacherId) {
    return request({
        url: `/eduservice/teacherFront/getTeacherFrontInfo/${teacherId}`,
        method: 'get'
    })
}
}