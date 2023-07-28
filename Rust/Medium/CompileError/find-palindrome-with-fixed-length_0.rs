impl Solution {
    pub fn kth_palindrome(queries: Vec<i32>, int_length: i32) -> Vec<i64> {
        
        let mut res: Vec<i64> = Vec::new();
        for q in queries {
            res.push(Self::find_kth_palindrome(q, int_length));
        }
        res
    }

    fn find_kth_palindrome(query: i32, int_length: i32) -> i64 {
        if query > 10_i32.pow(int_length as u32) {
            return -1;
        }
        let mut res: Vec<Vec<i32>> = Vec::new();
        for i in 0..=9 {
            res.push(vec![i]);
        }
        for len in 2..=int_length {
            let mut new_res: Vec<Vec<i32>> = Vec::new();
            for v in res {
                for i in 0..=9 {
                    let mut new_v: Vec<i32> = Vec::new();
                    new_v.push(i);
                    new_v.append(&mut v.clone());
                    new_v.push(i);
                    new_res.push(new_v);
                }
            }
            res = new_res;
        }
        let mut res_int: Vec<i64> = Vec::new();
        for v in res {
            let mut num: i64 = 0;
            for i in &v {
                num = num * 10 + *i as i64;
            }
            res_int.push(num);
        }
        res_int.sort();
        let mut res_int: Vec<i64> = res_int
            .into_iter()
            .filter(|x| x >= &query as &i64)
            .collect();
        if res_int.is_empty() {
            -1
        } else {
            res_int[0]
        }
    }
}