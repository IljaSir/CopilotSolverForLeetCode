impl Solution {
    pub fn maximum_beauty(flowers: Vec<i32>, new_flowers: i64, target: i32, full: i32, partial: i32) -> i64 {
        
        let mut v = flowers;
        v.sort();
        let mut ans = 0;
        for i in 0..v.len() {
            if v[i] >= target {
                ans += full as i64;
            }
        }
        let mut a = 0;
        let mut b = 0;
        for i in 0..v.len() {
            if v[i] < target {
                a += 1;
                b += v[i];
                if b >= target {
                    ans += full as i64;
                    ans += (a - 1) as i64 * partial as i64;
                    b = 0;
                    a = 0;
                }
            }
        }
        ans += (a * partial) as i64;
        ans += (b * partial) as i64;
        ans += (new_flowers - a as i64 * target as i64 - b as i64) / target as i64 * full as i64;
        ans
    }
}