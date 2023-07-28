impl Solution {
    pub fn get_kth(lo: i32, hi: i32, k: i32) -> i32 {
        
        let mut v = (lo..=hi).collect::<Vec<i32>>();
        v.sort_by_key(|&x| (Solution::power(x), x));
        v[k as usize - 1]
    }
    fn power(x: i32) -> i32 {
        let mut x = x;
        let mut p = 0;
        while x != 1 {
            if x % 2 == 0 {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            p += 1;
        }
        p
    }
}