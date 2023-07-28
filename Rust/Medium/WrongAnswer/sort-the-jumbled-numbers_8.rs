impl Solution {
    pub fn sort_jumbled(mapping: Vec<i32>, nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut mapping = mapping;
        let mut res = vec![];
        for i in 0..=9 {
            let mut tmp = vec![];
            for j in 0..nums.len() {
                if nums[j] == i {
                    tmp.push(nums[j]);
                } else {
                    let mut num = nums[j];
                    let mut new_num = 0;
                    while num > 0 {
                        let r = num % 10;
                        new_num = new_num * 10 + mapping[r as usize];
                        num /= 10;
                    }
                    if new_num == i {
                        tmp.push(nums[j]);
                    }
                }
            }
            res.append(&mut tmp);
        }
        res
    }
}