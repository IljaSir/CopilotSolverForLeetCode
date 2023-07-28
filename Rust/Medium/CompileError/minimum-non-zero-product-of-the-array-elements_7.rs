impl Solution {
    pub fn min_non_zero_product(p: i32) -> i32 {
        
        let mod_num = 1000000007;
        let max_num = 1 << p;
        let max_num = max_num - 1;
        let half_num = max_num >> 1;
        let ans = (half_num % mod_num) * (half_num + 1) % mod_num;
        let ans = ans * pow_mod(ans - 1, max_num - 2, mod_num) % mod_num;
        ans as i32
    }
}