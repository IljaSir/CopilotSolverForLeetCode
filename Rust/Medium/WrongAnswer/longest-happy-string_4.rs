impl Solution {
    pub fn longest_diverse_string(a: i32, b: i32, c: i32) -> String {
        
        let mut arr = vec![(a, 'a'), (b, 'b'), (c, 'c')];
        let mut res = String::new();
        loop {
            arr.sort();
            if arr[2].0 == 0 { break; }
            if arr[2].0 >= 2 && arr[1].0 > 0 {
                res.push(arr[2].1);
                res.push(arr[2].1);
                arr[2].0 -= 2;
                arr[1].0 -= 1;
            } else {
                res.push(arr[2].1);
                arr[2].0 -= 1;
            }
        }
        res
    }
}