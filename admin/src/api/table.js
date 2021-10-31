import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/userservice/hospital',
    method: 'get',
    params
  })
}
