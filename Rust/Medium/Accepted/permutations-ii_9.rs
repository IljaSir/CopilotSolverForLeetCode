impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort_unstable();
        let mut ret = vec![vec![]];
        for &num in nums.iter() {
            let mut new_ret = vec![];
            for r in ret {
                for i in 0..=r.len() {
                    let mut new_r = r.clone();
                    new_r.insert(i, num);
                    if !new_ret.contains(&new_r) {
                        new_ret.push(new_r);
                    }
                }
            }
            ret = new_ret;
        }
        ret
    }
}