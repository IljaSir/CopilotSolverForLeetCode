impl Solution {
    pub fn min_stone_sum(piles: Vec<i32>, k: i32) -> i32 {
        
        let mut arr = piles;
        let mut k = k;
        let mut sum = 0;
        for i in &arr {
            sum += i;
        }
        while k > 0 {
            arr.sort();
            let len = arr.len();
            let max = arr[len - 1];
            let new_max = max / 2;
            sum -= new_max;
            arr[len - 1] = new_max;
            k -= 1;
        }
        sum
    }
}