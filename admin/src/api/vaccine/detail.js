import request from '@/utils/request'

export default {

  //全部获取
  getVaccineList(hospitalId,vaccineQuery) {
    return request({
      url: `/userservice/injection/getPageList/${hospitalId}`,
      method: 'post',
      data:vaccineQuery
    })
  },
  getById(id) {
    return request({
      url: `/userservice/injection/getDetail/${id}`,
      method: 'get'
    })
  },
  
}