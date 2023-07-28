impl Solution {
    pub fn fill_cups(amount: Vec<i32>) -> i32 {
        
        let mut cache = vec![vec![-1; 101]; 101];
        Solution::fill_cups_helper(&amount, 0, 0, &mut cache)
    }
    fn fill_cups_helper(amount: &Vec<i32>, cold: i32, warm: i32, cache: &mut Vec<Vec<i32>>) -> i32 {
        let hot = amount[0] + amount[1] + amount[2] - cold - warm;
        if hot < 0 {
            return 0;
        }
        if cold < 0 || warm < 0 || hot < 0 {
            return 0x3f3f3f3f;
        }
        if cold == 0 && warm == 0 && hot == 0 {
            return 0;
        }
        if cache[cold as usize][warm as usize] != -1 {
            return cache[cold as usize][warm as usize];
        }
        let mut result = 0x3f3f3f3f;
        if amount[0] > 0 {
            result = result.min(Solution::fill_cups_helper(amount, cold - 1, warm - 1, cache) + 1);
        }
        if amount[1] > 0 {
            result = result.min(Solution::fill_cups_helper(amount, cold - 1, warm - 1, cache) + 1);
        }
        if amount[2] > 0 {
            result = result.min(Solution::fill_cups_helper(amount, cold - 1, warm - 1, cache) + 1);
        }
        if amount[0] > 0 && amount[1] > 0 {
            result = result.min(Solution::fill_cups_helper(amount, cold - 1, warm - 2, cache) + 2);
        }
        if amount[0] > 0 && amount[2] > 0 {
            result = result.min(Solution::fill_cups_helper(amount, cold - 1, warm - 2, cache) + 2);
        }
        if amount[1] > 0 && amount[2] > 0 {
            result = result.min(Solution::fill_cups_helper(amount, cold - 2, warm - 1, cache) + 2);
        }
        if amount[0]
    }
}