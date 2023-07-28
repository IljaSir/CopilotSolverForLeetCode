impl Solution {
    pub fn find_different_binary_string(nums: Vec<String>) -> String {
        
        let mut res = String::from("");
        for i in 0..nums.len() {
            let mut tmp = String::from("");
            for j in 0..nums[i].len() {
                if nums[i].chars().nth(j).unwrap() == '0' {
                    tmp.push('1');
                } else {
                    tmp.push('0');
                }
            }
            if !nums.contains(&tmp) {
                res = tmp;
                break;
            }
        }
        if res == "" {
            res = "0".repeat(nums.len());
        }
        res
    }
}