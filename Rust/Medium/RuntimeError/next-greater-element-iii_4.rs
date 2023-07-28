impl Solution {
    pub fn next_greater_element(n: i32) -> i32 {
        

        let mut nums = n.to_string().chars().collect::<Vec<char>>();
        let mut i = nums.len() - 1;
        while i > 0 && nums[i] <= nums[i - 1] {
            i -= 1;
        }
        if i == 0 {
            return -1;
        }
        let mut j = nums.len() - 1;
        while nums[j] <= nums[i - 1] {
            j -= 1;
        }
        nums.swap(i - 1, j);
        nums[i..].reverse();
        let mut res = String::new();
        for c in nums {
            res.push(c);
        }
        let res = res.parse::<i32>().unwrap();
        if res > i32::MAX {
            return -1;
        }
        res
    }
}