impl Solution {
    pub fn check_arithmetic_subarrays(nums: Vec<i32>, l: Vec<i32>, r: Vec<i32>) -> Vec<bool> {
        
        let mut res = Vec::new();
        for i in 0..l.len() {
            let mut v = nums[l[i] as usize..=r[i] as usize].to_vec();
            v.sort();
            let mut ok = true;
            for j in 0..v.len() - 1 {
                if j == 0 {
                    if v[1] - v[0] != v[v.len() - 1] - v[v.len() - 2] {
                        ok = false;
                        break;
                    }
                } else {
                    if v[j + 1] - v[j] != v[1] - v[0] {
                        ok = false;
                        break;
                    }
                }
            }
            res.push(ok);
        }
        res
    }
}