impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut ans = 0;
        let mut arr: Vec<i32> = arr.iter().map(|s| s.chars().fold(0, |acc, c| acc | 1 << (c as i32 - 'a' as i32))).filter(|&x| x.count_ones() == x.count_zeros()).collect();
        dfs(0, 0, &mut arr, &mut ans);
        ans
    }
}