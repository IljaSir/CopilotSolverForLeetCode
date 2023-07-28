impl Solution {
    pub fn kth_palindrome(queries: Vec<i32>, int_length: i32) -> Vec<i64> {
        
        let mut ans = Vec::new();
        for i in 0..queries.len() {
            let mut num = queries[i];
            let mut count = 0;
            while num > 0 {
                num /= 10;
                count += 1;
            }
            if count > int_length as i32 {
                ans.push(-1);
                continue;
            }
            let mut num = queries[i];
            let mut res = vec![0; int_length as usize];
            for i in 0..int_length as usize / 2 {
                res[i] = num % 10;
                res[int_length as usize - i - 1] = num % 10;
                num /= 10;
            }
            if int_length as usize % 2 == 1 {
                res[int_length as usize / 2] = num % 10;
            }
            let mut res2 = res.clone();
            res2.reverse();
            let mut res3 = vec![0; int_length as usize * 2];
            for i in 0..int_length as usize {
                res3[i] = res[i];
                res3[i + int_length as usize] = res2[i];
            }
            let mut res4 = res3.clone();
            res4.reverse();
            let mut res5 = vec![0; int_length as usize * 3];
            for i in 0..int_length as usize * 2 {
                res5[i] = res3[i];
                res5[i + int_length as usize * 2] = res4[i];
            }
            let mut res6 = res5.clone();
            res6.reverse();
            let mut res7 = vec![0; int_length as usize * 4];
            for i in 0..int_length as usize * 3 {
                res7[i] = res5[i];
                res7[i + int_length as usize * 3] = res6[i];
            }
            let mut res8 = res7.clone();
            res8.reverse();
            let mut res9 = vec![0; int_length as usize * 5];
            for i in 0..int_length as usize * 4 {
                res9[i] = res7[i];
                res9[i + int_length as usize * 4] = res8[i];
            }
            let mut res10 = res9.clone();
            res10
    }
}