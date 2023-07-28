impl Solution {
    pub fn count_nice_pairs(nums: Vec<i32>) -> i32 {
        
        let mut cnt = vec![0; 100001];
        let mut res = 0;
        let mut modu = 1000000007;
        for n in nums {
            let rev = n.to_string().chars().rev().collect::<String>().parse::<i32>().unwrap();
            let diff = (n - rev).abs();
            res = (res + cnt[diff as usize]) % modu;
            cnt[diff as usize] += 1;
        }
        res
    }
}