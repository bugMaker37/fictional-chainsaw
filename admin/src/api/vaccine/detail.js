import request from '@/utils/request'

export default {

  //全部获取
  getVaccineList(hospitalId,vaccineQuery) {
    return request({
      url: `/userservice/injection/getPagelist/${hospitalId}`,
      method: 'post',
      data:vaccineQuery
    })
  },
  
}