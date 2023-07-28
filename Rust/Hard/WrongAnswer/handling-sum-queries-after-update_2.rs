impl Solution {
    pub fn handle_query(nums1: Vec<i32>, nums2: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<i64> {
        
        let mut nums1 = nums1;
        let mut res = vec![];
        let mut sum = nums2.iter().sum::<i32>() as i64;
        for q in queries {
            if q[0] == 1 {
                let l = q[1] as usize;
                let r = q[2] as usize;
                for i in l..=r {
                    nums1[i] ^= 1;
                    sum += if nums1[i] == 1 { 1 } else { -1 } * nums2[i] as i64;
                }
            } else if q[0] == 2 {
                let p = q[1] as i64;
                sum += nums1.iter().sum::<i32>() as i64 * p;
            } else {
                res.push(sum);
            }
        }
        res
    }
}