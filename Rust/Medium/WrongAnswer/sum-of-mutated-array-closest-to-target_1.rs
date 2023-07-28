impl Solution {
    pub fn find_best_value(arr: Vec<i32>, target: i32) -> i32 {
        
        let (mut l, mut r) = (0, *arr.iter().max().unwrap());
        while l < r {
            let m = (l + r + 1) / 2;
            let sum = arr.iter().map(|&x| if x > m { m } else { x }).sum::<i32>();
            if sum > target {
                r = m - 1;
            } else {
                l = m;
            }
        }
        l
    }
}