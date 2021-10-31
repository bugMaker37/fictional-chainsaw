import request from '@/utils/request'

export default {

  //全部获取
  getVaccineList(hospitalId,vaccineQuery) {
    return request({
      url: `/userservice/veccines/getPageList/${hospitalId}`,
      method: 'post',
      data:vaccineQuery
    })
  },
  save(vaccine) {
    return request({
      url: `/userservice/veccines/save`,
      method: 'post',
      data: vaccine

    })
  },
  getById(id) {
    return request({
      url: `/userservice/veccines/getVaccine/${id}`,
      method: 'get'
    })
  },
  updateTeacher(vaccine) {
    return request({
      url: `/userservice/veccines/updateVaccine`,
      method: 'post',
      data: vaccine
    })
  },

  delete(id) {
    return request({
      url: `/userservice/veccines/delete/${id}`,
      method: 'delete',
    })
  },
}