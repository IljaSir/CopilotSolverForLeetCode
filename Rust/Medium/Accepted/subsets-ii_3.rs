impl Solution {
    pub fn subsets_with_dup(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut ans = vec![vec![]];
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            let mut j = i;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }
            let mut temp = vec![];
            for v in ans.iter() {
                let mut t = v.clone();
                for _ in 0..j-i {
                    t.push(nums[i]);
                    temp.push(t.clone());
                }
            }
            ans.extend(temp);
            i = j;
        }
        ans
    }
}