impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = vec![vec![]];
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            let mut tmp = vec![];
            for r in res.iter() {
                tmp.push(r.clone());
            }
            for r in tmp.iter_mut() {
                for _ in i..j {
                    r.push(nums[i]);
                    res.push(r.clone());
                }
            }
            i = j;
        }
        res
    }
}