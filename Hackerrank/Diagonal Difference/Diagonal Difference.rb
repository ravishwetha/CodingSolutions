#!/bin/ruby

require 'json'
require 'stringio'

# Complete the diagonalDifference function below.
def diagonalDifference(arr)
    len = arr.length
    sum1 = 0
    sum2 = 0
    0.upto(len-1).each do |i|
        sum1 += arr[i][i]
        sum2 += arr[i][len-1-i]
    end
    (sum1 - sum2).abs
end

fptr = File.open(ENV['OUTPUT_PATH'], 'w')

n = gets.to_i

arr = Array.new(n)

n.times do |i|
    arr[i] = gets.rstrip.split(' ').map(&:to_i)
end

result = diagonalDifference arr

fptr.write result
fptr.write "\n"

fptr.close()
