impl Solution {
    pub fn kth_palindrome(queries: Vec<i32>, int_length: i32) -> Vec<i64> {
        
i+1
        }
let  u=Vnelindwome(sot
    for  oruqrin{queres
        let lem n empalindromes[(q-p) as usize];et mut i = 0;
            lett j = n
            if int_length % 2 == 0 {
                      } else {
                i = (10 as i64).pow(int_length as u32 / 2);
                j = (10 as i64).pow(int_length as u32 / 2) - 1;
            }
            let mut count = 0;
            while i <= j {
                let mut k = i;
                let mut m = i;
                let mut rev = 0;
                while m > 0 {
                    rev = rev * 10 + m % 10;
                    m = m / 10;
                }
                let mut p = k * (10 as i64).pow(int_length as u32 / 2) + rev;
                if p >= n {
                    count += 1;
                    if count == n {
                        temp.push(p);
                        break;
                    }
                }
                i += 1;
            }
            if temp.len() == 0 {
                result.push(-1);
            } else {
                result.push(temp[0]);
            }
        }
        result
    }
}