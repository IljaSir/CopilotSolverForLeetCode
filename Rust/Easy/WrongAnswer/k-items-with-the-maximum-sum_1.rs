impl Solution {
    pub fn k_items_with_maximum_sum(num_ones: i32, num_zeros: i32, num_neg_ones: i32, k: i32) -> i32 {
        
        let mut res = 0;
        let mut ones = num_ones;
        let mut zeros = num_zeros;
        let mut neg_ones = num_neg_ones;
        let mut k = k;
        if k < 0 {
            return 0;
        }
        if k <= num_zeros {
            return k as i32;
        }
        if k > num_ones + num_zeros + num_neg_ones {
            return num_ones + 2 * num_zeros + num_neg_ones;
        }
        if k <= num_ones + num_zeros {
            res += k - num_zeros;
            k -= res;
        } else {
            res += num_ones;
            k -= num_ones;
            res -= k;
            k = 0;
        }
        res
    }
}