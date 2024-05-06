package com.oguilhermeviana.academy.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe utilitária para fornecer métodos úteis.
 *
 * @author Guilherme Viana
 */
public class Util {

  /**
   * Calcula o hash MD5 de uma senha.
   *
   * @param senha A senha a ser convertida para o hash MD5.
   * @return O hash MD5 da senha como uma string hexadecimal.
   * @throws NoSuchAlgorithmException Se o algoritmo MD5 não estiver disponível.
   */
  public static String md5(String senha) throws NoSuchAlgorithmException {
    // Obtém uma instância do algoritmo de hash MD5
    MessageDigest messageDigest = MessageDigest.getInstance("MD5");

    // Calcula o hash da senha e converte para um número inteiro positivo
    byte[] digest = messageDigest.digest(senha.getBytes());
    BigInteger hash = new BigInteger(1, digest);

    // Retorna o hash MD5 como uma string hexadecimal
    return hash.toString(16);
  }
}
