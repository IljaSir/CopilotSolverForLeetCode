impl Solution {
    pub fn permute_unique(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut nums = nums;
        nums.sort();
        let mut ret = vec![vec![]];
        for &num in nums.iter() {
            let mut tmp = vec![];
            for mut v in ret {
                for i in 0..=v.len() {
                    let mut w = v.clone();
                    w.insert(i, num);
                    if !tmp.contains(&w) {
                        tmp.push(w);
                    }
                }
            }
            ret = tmp;
        }
        ret
    }
}