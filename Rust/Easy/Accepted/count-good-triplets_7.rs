impl Solution {
    pub fn count_good_triplets(arr: Vec<i32>, a: i32, b: i32, c: i32) -> i32 {
        
        let mut count = 0;
        for i in 0..arr.len()-2 {
            for j in i+1..arr.len()-1 {
                for k in j+1..arr.len() {
                    let (x, y, z) = (arr[i], arr[j], arr[k]);
                    if (x - y).abs() <= a && (y - z).abs() <= b && (x - z).abs() <= c {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}